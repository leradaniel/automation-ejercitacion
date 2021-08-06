# Ejercitación inicial de automation (Selenium + TestNG)
Usar el archivo "Base" de la carpeta target\test-classes\SeleniumTraining para resolver las siguientes consignas (crear los archivos en esa misma carpeta)


Exercise #1 - Perform a Google search
• Navigate Google Home page.
• Define and perform Home page validations.
• Perform a search for the following term: "Selenium"
• Click first result
• Validate page title "SeleniumHQ Browser Automation"


Exercise #2 - More realistic situation - Login
• Given the following URL: https://testappautomation.herokuapp.com 
• Validate Un-logged Home page:
    Validate Page Title=Home Page 
    Validate Login button exists
    Validate Hyperlinks are not accessible if not logged in. 
    Validate page Texts:
        "Welcome to my Automaticn Testing Site"
        "Please click Login button to log into the application or sign up!"
• Validate Footer is fixed in at the bottom of the page with the following text: "Disclaimer: This project is a personal site meant to be used as a help test site to be able to perform some automation test on demand."
• Attempt to log in with invalid Empty user/password combination: 
    User: "" Password: "Password"
    Password: "Password" User: ""
• Attempto to log in with valid user/password combinations:
    User: From step 3
    Password: Different from step 3
• Valid user/password combination:
    User: Valid user
     Password: Valid Password
• Successfully logged and redirected to Home
• Logout button is displayed instead of login, and your avatar is displayed with the following message at its left: Welcome "your user"! 


Exercise #3 - Lorem Ipsum
• Once in the home page validate the following: 
    Header and Footer identical in the same way you did on the page Home 
• News section is visible with the following text displayed:
    Notice: This is a testing site meant to be used for automation test trainings"
• Id: news 
• The folllowing text should be visible within the next selector: 
    ID: "hiddenText1" 
    Text: "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
• Once we have access to the page, validate the following sections:
    ¿Qué es Lorem Ipsum?
    ¿Por qué lo usamos?
    ¿De dónde viene?
    ¿Dónde puedo conseguirlo?
• Validate Links to Selenium, Youtube and Facebook exists and open in the same page 


Exercise #4 - Play
• Once in the forms page validate the following: 
    Header and Footer identical to Home and Loren Ipsun 
• Page title = Forms Page 
• Fill all available controls. 
• Submit 
• Once redirected to Results page validate the following: 
    page Title = "Result page" 
    Displayed data matches with the one you just filled in
• Click Log Out -> you should be redirected to Home page, Log out button, profile avatar and welcome message do not exist any more and log in button exists instead
