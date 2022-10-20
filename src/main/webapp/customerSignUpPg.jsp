<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Sign Up</title>
</head>
<body>
<center>
        <h1>Enter Details To Register</h1>
        <form action ="customerSignUp" method="post">
            <table>
                <tr>
                    <td>Your Name</td>
                    <td><input type="text" name="name" placeholder="Joe xyz" required></td>
                </tr>
                 
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="enter easy password" required></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="cpassword" placeholder="same as password" required></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" placeholder="joe123@somemail.com" required></td>
                </tr>
                <tr>
                    <td>Mobile No.</td>
                    <td><input type="number" name="mobile" placeholder="+919140064294" minlength=10 maxlenght=10 required></td>
                </tr>
                
                
                <tr>
                    <td><small> Click <a href="customerSignInPg.jsp">Here</a>to login </small> </td>
                    <td><input type="submit" value="register me" ></td>
                </tr>
            </table><br><br><br><br><br>
            
        </form>
    </center>
</body>
</html>