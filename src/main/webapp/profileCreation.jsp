<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Creation</title>
</head>
<body>
<center>
        <h1>Enter For Profile Creation</h1>
        <form action ="ProfileCreation" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Touch ID</td>
                    <td><input type="text" name="touchID" placeholder="Joe xyz" required></td>
                </tr>
                 <tr>
                    <td>Profile Pic</td>
                    <td><input type="file" name="profilePic" placeholder="Your Pic" required></td>
                </tr>
                <tr>
                    <td>Bio</td>
                    <td><input type="text" name="bio" placeholder="enter bio" required></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td><input type="text" name="status" placeholder="what are you feeling now" required></td>
                </tr>
                <tr>
                    <td>Your Interests</td>
                    <td><input type="text" name="interests" placeholder="what are you Interested in" required></td>
                </tr>
                <tr>
                    <td>When Did You First Cry</td>
                    <td><input type="date" name="dob" placeholder="25/12/2000" required></td>
                </tr>
                
                <tr>
                    <td><small> Click <a href="homePg.jsp">Here</a>to go to Home Page </small> </td>
                    <td><input type="submit" value="Submit" ></td>
                </tr>
            </table><br><br><br><br><br>
            
        </form>
    </center>
</body>
</html>