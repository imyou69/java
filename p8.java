<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <form action="Login.jsp" method="post" id="styleform">
        <h2>Login Authentication</h2>
        <hr color="black"><br>
        Username: <input type="text" name="user"/><br><br>
        Password: <input type="password" name="pwd"/><br><br><br>
        <input type="submit" value="Submit" id="stylesub"/>
    </form>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
<%@ page import ="java.sql.*" %>
<%
    String username = request.getParameter("user");
    String pwd = request.getParameter("pwd");

    if (username != null && pwd != null) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root");
            String query = "SELECT * FROM login WHERE username = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, username);
            rs = pst.executeQuery();

            if (rs.next()) {
                if (rs.getString("password").equals(pwd)) {
                    session.setAttribute("user", rs.getString("username"));
                    String name = (String) session.getAttribute("user");
                    out.println("Welcome " + name);
                } else {
                    out.println("Invalid password, try again.");
                }
            } else {
                out.println("Username not found.");
            }
        } catch (Exception e) {
            out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                out.println("An error occurred while closing resources: " + e.getMessage());
            }
        }
    } else {
        out.println("Username and password cannot be empty.");
    }
%>
</body>
</html>
