<!DOCTYPE html>
<html>

<body>

<h1>Login and Register GUI with MySQL Database Connection </h1>

<p><strong>LoginRegisterGUIDatabase</strong> is a Java application that provides a simple user authentication system using Swing GUI components. It allows users to log in and register for an account. The project consists of several classes that handle different aspects of the application's functionality. Checkout the full video tutorial of where I go step by step explaining the process of building it here: https://youtu.be/fA9_KzJSrNQ</p>

<h2>Table of Contents</h2>

<ol>
   <li><a href="#classes">Classes</a>
        <ul>
            <li><a href="#applauncher">AppLauncher</a></li>
            <li><a href="#loginformgui">LoginFormGUI</a></li>
            <li><a href="#registerformgui">RegisterFormGUI</a></li>
            <li><a href="#form">Form</a></li>
            <li><a href="#myjdbc">MyJDBC</a></li>
            <li><a href="#commonconstants">CommonConstants</a></li>
        </ul>
    </li>
</ol>

<h2 id="classes">Classes</h2>

<h3 id="applauncher">AppLauncher</h3>
<p>The <code>AppLauncher</code> class contains the main method that launches the application. It creates an instance of the <code>LoginFormGUI</code> class to start the login process.</p>

<h3 id="form">Form</h3>
<p>The <code>Form</code> class is a base class for the GUI forms used in the application. It sets up common properties for all GUI forms, such as title, size, layout, and background color.</p>

<h3 id="loginformgui">LoginFormGUI</h3>
<p>The <code>LoginFormGUI</code>class handles the user interface for the login form. It allows users to enter their username and password to log in. It also provides a link to the registration form for new users.</p>

<h3 id="registerformgui">RegisterFormGUI</h3>
<p>The <code>RegisterFormGUI</code> class is responsible for the user interface of the registration form. It enables users to create a new account by entering a username, password, and re-entering the password for confirmation.</p>

<h3 id="myjdbc">MyJDBC</h3>
<p>The <code>MyJDBC</code> class provides methods for interacting with the MySQL database. It handles user registration, checking if a user exists, and validating login credentials.</p>

<h3 id="commonconstants">CommonConstants</h3>
<p>The <code>CommonConstants</code> class holds constant values used throughout the application, such as color codes for UI elements and database connection details.</p>

<h2>Usage</h2>

<p>To use the <strong>AppLauncher</strong> application:</p>
<ol>
    <li>Ensure you have a MySQL database set up with the required schema.</li>
    <li>Update the database connection details in the <code>CommonConstants</code> class.</li>
    <li>Compile and run the <code>AppLauncher</code> class.</li>
    <li>The login form will appear, allowing users to log in with existing credentials or register for a new account.</li>
</ol>
</body>

</html>
