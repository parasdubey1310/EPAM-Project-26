const hoverText = document.getElementById("hoverText");
const registerBtn = document.getElementById("registerBtn");
const instructions = document.getElementById("instructions");
const steps = document.getElementById("steps");
const message = document.getElementById("message");

hoverText.addEventListener("mouseover", function () {
    alert("Welcome to XYZ Bank Customer Portal!");
});

registerBtn.addEventListener("click", function () {
    instructions.style.display = "none";
    steps.style.display = "none";

    alert("Registration started!");
});

function validateCustomer() {

    const customerID = document.getElementById("custID").value.trim();

    if (customerID === "") {
        message.innerHTML = "Please enter your Customer ID.";
        return;
    }

    if (customerID.includes("XYZ")) {

        message.innerHTML = "Customer ID is valid.";

    } else {

        message.innerHTML = "Invalid Customer ID. Customer ID must contain XYZ.";

    }
}

function generateCoupon() {

    const customerID = document.getElementById("custID").value.trim();

    if (customerID === "") {
        message.innerHTML = "Please enter your Customer ID.";
        return;
    }

    if (customerID.includes("XYZ")) {

        const couponNumber = Math.floor(Math.random() * 9000) + 1000;

        message.innerHTML =
            "Congratulations! Your Diwali Coupon is XYZ" + couponNumber;

    } else {

        message.innerHTML =
            "Please enter a valid Customer ID before generating a coupon.";

    }
}