Step 1:-Create a maven project
Step 2:Divide your project into different structure like src/main/java,src/test/java.Inside your src/main/java create different packages for config
,general package for Base class,page using Page Factory model.And util pkg where all common methods are defined
Step 3:-Create a base class.where we are calling the properties from config file.And setting the chrome browser
Step 4.As this is a maven project so pom file will be created automatically declare your dependencies like testng,
surefire-plugin,extent-reports etc.
Step 5:Create a page class inside com.framework.pages.By using FindBy annotation we are declaring webelements present on the food ordering site
Step 6:Then in your test folder,create a class calling OrderPage.For each pom page there should be java test class
And use testng annotation to declare this FoodOrder testClass. Create method for ordering and then call method of PageClass where you can order food on the basis of pincode
Step7:Convert your test class into testng xml
Step 8:Then in your test-output you can see the results
Step 9:We can store the screenshots too using ScreenshotLib.java class
