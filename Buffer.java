ubmit.setOnClickListener(new OnClickListener() {


    @Override
    public void onClick(View view) {
        if (!ques_answers.isEmpty()) {
            ques_answers.clear();
        }
        if (!ques_paths.isEmpty()) {
            ques_paths.clear();
        }
        if (!ques_ids.isEmpty()) {
            ques_ids.clear();
            ques_types.clear();
        }

        canProceed = true;
        furtherCheck = true;

        int noLinearChildren = mainsurvey.getChildCount();

        for (int i = 1; i < noLinearChildren; i++) {

            if (i % 2 == 0) {

            } else {

                LinearLayout linearChild = (LinearLayout) mainsurvey
                        .getChildAt(i);

                int j = (i - 1) / 2;

                // j = j - 1;

                if ((questionsBeanVector.get(j)
                        .getType_of_question()
                        .equalsIgnoreCase("textbox"))
                        || (questionsBeanVector.get(j)
                        .getType_of_question()
                        .equalsIgnoreCase("textarea"))
                        || (questionsBeanVector.get(j)
                        .getType_of_question()
                        .equalsIgnoreCase("date") || qb
                        .getQuestion().equalsIgnoreCase(
                                "Name"))) {
                    SimpleDateFormat sdf = new SimpleDateFormat(
                            "dd-MM-yyyy");
                    EditText valueChildText = (EditText) linearChild
                            .getChildAt(0);
                    valueChildText.clearFocus();
                    valueChildText.setFocusable(false);
                    removeFocusOnDone(valueChildText);
                    String edit_answers = "";
                    if (valueChildText != null) {
                        edit_answers = valueChildText.getText()
                                .toString();
                        Bundle name = new Bundle();
                        name.putString("Name", edit_answers);

                    }
                    if (edit_answers.contains(";")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                view.getContext());

                        builder.setMessage(
                                "Please avoid using special characters")
                                .setCancelable(false)
                                .setPositiveButton(
                                        "Ok",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int id) {
                                                dialog.cancel();

                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.setTitle("Error !!");
                        alert.setIcon(R.drawable.error);
                        alert.show();
                        canProceed = false;
                        furtherCheck = false;
                    }

                    if (edit_answers == null
                            || edit_answers.trim().equals("")) {
                        edit_answers = "***";

                        ques_answers.add(edit_answers.trim());

                    } else {

                        if (questionsBeanVector.get(j)
                                .getType_of_question()
                                .equalsIgnoreCase("date")) {
                            try {
                                Date date = sdf.parse(edit_answers);

                                edit_answers = edit_answers
                                        .replace(",", "");
                                edit_answers = edit_answers
                                        .replace(";", "");

                                ques_answers.add(edit_answers
                                        .trim());
                            } catch (Exception e) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(
                                        view.getContext());

                                builder.setMessage(
                                        "Please enter correct format of date. Click select date to select. ")
                                        .setCancelable(false)
                                        .setPositiveButton(
                                                "Ok",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(
                                                            DialogInterface dialog,
                                                            int id) {
                                                        dialog.cancel();

                                                    }
                                                });
                                AlertDialog alert = builder
                                        .create();
                                alert.setTitle("Error !!");
                                alert.setIcon(R.drawable.error);
                                alert.show();

                                canProceed = false;
                                furtherCheck = false;

                            }
                        } else {
                            edit_answers = edit_answers.replace(
                                    ",", "");
                            edit_answers = edit_answers.replace(
                                    ";", "");

                            ques_answers.add(edit_answers.trim());
                        }

                    }

                    if (!questionsBeanVector.get(j).getPath()
                            .equalsIgnoreCase("")) {
                        ques_paths.add(questionsBeanVector.get(j)
                                .getPath());
                    } else {
                        ques_paths.add(" ");
                    }

                } else if (questionsBeanVector.get(j)
                        .getType_of_question()
                        .equalsIgnoreCase("emailid"))

                {

                    EditText valueChildText = (EditText) linearChild
                            .getChildAt(0);
                    valueChildText.clearFocus();
                    valueChildText.setFocusable(false);
                    removeFocusOnDone(valueChildText);
                    String edit_answers = "";
                    if (valueChildText != null) {
                        edit_answers = valueChildText.getText()
                                .toString();

                    }

                    boolean isEmailIdValid = isEmailValid(edit_answers);

                    if (edit_answers == null
                            || edit_answers.trim().equals("")) {
                        edit_answers = "***";

                        ques_answers.add(edit_answers.trim());

                    } else {

                        if (!isEmailIdValid) {
                            canProceed = false;
                            AlertDialog.Builder builder = new AlertDialog.Builder(
                                    v.getContext());
                            builder.setMessage(
                                    "Please enter proper email ID")
                                    .setCancelable(false)
                                    .setPositiveButton(
                                            "Ok",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(
                                                        DialogInterface dialog,
                                                        int id) {
                                                    dialog.cancel();
                                                }
                                            });
                            AlertDialog alert = builder.create();
                            alert.setTitle("Error !!");
                            alert.setIcon(R.drawable.error);
                            alert.show();
                        } else

                            edit_answers = edit_answers.replace(
                                    ",", "");
                        edit_answers = edit_answers
                                .replace(";", "");

                        ques_answers.add(edit_answers.trim());

                    }

                    if (!questionsBeanVector.get(j).getPath()
                            .equalsIgnoreCase("")) {
                        ques_paths.add(questionsBeanVector.get(j)
                                .getPath());
                    } else {
                        ques_paths.add(" ");
                    }

                } else if ((questionsBeanVector.get(j)
                        .getType_of_question()
                        .equalsIgnoreCase("checkbox"))) {
                    //Toast.makeText(getApplicationContext(), "checkbox answers ", Toast.LENGTH_LONG).show();
                    String checkbox_answer = "";
                    String kvalue = "";
                    String options[] = questionsBeanVector.get(j)
                            .getOptions().split(";");
                    //CheckBox checkboxChild = null;
                    int countofoptions = 0;
                    StringBuffer buf = new StringBuffer();
                    for (int k = 0; k < options.length; k++) {

                        // String check = "**";
                        String check = "";
                        int check_kval = -1;

                        CheckBox checkboxChild = (CheckBox) linearChild.getChildAt(k);

                        if (checkboxChild.isChecked()) {

                            check = checkboxChild.getText()
                                    .toString();
                            check_kval = k + 1;
                            countofoptions++;
                        }
                        if (check.trim().length() == 0
                                || check.trim().equalsIgnoreCase("")) {
                            check = "**";

                            checkbox_answer = checkbox_answer
                                    .trim() + ";" + check;
                            if (buf.length() == 0)
                                buf.append(check_kval);
                            else
                                buf.append(";" + check_kval);


                        } else {
                            checkbox_answer = checkbox_answer
                                    .trim() + ";" + check;
                            if (buf.length() == 0)
                                buf.append(check_kval);
                            else
                                buf.append(";" + check_kval);
                        }


                    }
                    kvalue = buf.toString();
                    checkbox_answer = checkbox_answer.replace(",", "");
                    kvalue = kvalue.replace("-1", "");
                    final int checkbox_length = checkbox_answer.split(";").length;
                    int kvalue_velgth = kvalue.split(";").length;
                        ques_answers.add(kvalue);
                        ques_paths.add(" ");
                } else if ((questionsBeanVector.get(j)
                        .getType_of_question()
                        .equalsIgnoreCase("radio"))) {
                    int previous = j - 1;
                    String radio_answers = "";
                    //Toast.makeText(getApplicationContext(), "file path into", Toast.LENGTH_LONG).show();
                    String options[] = questionsBeanVector.get(j)
                            .getOptions().split(";");

                    RadioGroup radioGroup = (RadioGroup) linearChild
                            .getChildAt(0);
                    String rvalue = "";

                    for (int k = 0; k < options.length; k++) {
                        int val = -1;
                        RadioButton radioChild = (RadioButton) radioGroup
                                .getChildAt(k);
                        String radio = "";
                        if (radioChild.isChecked() == true) {
                            radio = radioChild.getText().toString();


                            val = k + 1;
                        }
                        radio_answers = radio;
                        rvalue += val;

                    }

                    rvalue = rvalue.replace("-1", "");
                    if (rvalue.trim().equalsIgnoreCase("")) {
                        rvalue = "***";
                    }

                    ques_paths.add(" ");
