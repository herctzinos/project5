$(".log-in").click(function () {
    $(".signIn").addClass("active-dx");
    $(".signUp").addClass("inactive-sx");
    $(".signUp").removeClass("active-sx");
    $(".signIn").removeClass("inactive-dx");
});

$(".back").click(function () {
    $(".signUp").addClass("active-sx");
    $(".signIn").addClass("inactive-dx");
    $(".signIn").removeClass("active-dx");
    $(".signUp").removeClass("inactive-sx");
});
var password1 = document.getElementById("password1")
        , password2 = document.getElementById("password2");

function validatePassword() {
    if (password1.value != password2.value) {
        password2.setCustomValidity("Passwords Don't Match");
    } else {
        password2.setCustomValidity('');
    }
}

password2.onchange = validatePassword;
password2.onkeyup = validatePassword;


$(".cagree").on("change", function(e){
  if($(".cagree").attr("checked")){
    $(".submit").button("enable");
  } else {
    $(".submit").button("disable");
  }
  
});