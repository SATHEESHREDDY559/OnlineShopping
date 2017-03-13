function validateForm() {
    var name = document.forms["form1"]["name"].value;
    var pwd = document.forms["form1"]["password"].value;
    if (name== ""||name.equals("")||pwd== ""||pwd.equals("")) {
        alert("Form fields must be filled out");
        return false;
    }
    return true;
}