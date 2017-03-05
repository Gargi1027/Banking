<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="inactive-server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>FT Banking System</title>
        <meta name="description" content="Description" />
        <meta name="keywords" content="Keywords" />


        <link rel="stylesheet" href="style.css" type="text/css" media="screen" />


        <script type="text/javascript" src="jquery.js"></script>
        <script type="text/javascript" src="script.js"></script>
    </head>
    <body>
        <div id="art-main">
            <div class="art-sheet">
                <div class="art-sheet-tl"></div>
                <div class="art-sheet-tr"></div>
                <div class="art-sheet-bl"></div>
                <div class="art-sheet-br"></div>
                <div class="art-sheet-tc"></div>
                <div class="art-sheet-bc"></div>
                <div class="art-sheet-cl"></div>
                <div class="art-sheet-cr"></div>
                <div class="art-sheet-cc"></div>
                <div class="art-sheet-body">
                    <div class="art-nav">
                        <div class="art-nav-l"></div>
                        <div class="art-nav-r"></div>
                    </div>
                    <div class="cleared reset-box"></div>
                    <div class="art-header">
                        <div class="art-header-clip">
                            <div class="art-header-center">
                                <div class="art-header-png"></div>
                                <div class="art-header-jpeg"></div>
                            </div>
                        </div>
                        <div class="art-logo">
                            <h1 class="art-logo-name"><a href="#">FT Banking System</a></h1>
                        </div>
                    </div>
                    <div class="cleared reset-box"></div>
                    <div class="art-content-layout">
                        <div class="art-content-layout-row">
                            <div class="art-layout-cell art-sidebar1">
                                <div class="art-vmenublock">
                                    <div class="art-vmenublock-body">
                                        <div class="art-vmenublockcontent">
                                            <div class="art-vmenublockcontent-body">
                                                <div class="cleared"></div>
                                            </div>
                                        </div>
                                        <div class="cleared"></div>
                                    </div>
                                </div>


                                <div class="cleared"></div>
                            </div>
                            <div class=" art-content">
                                <div class="art-post">

                                    <form method="post" action="registration2.jsp">
                                        <%
                                            String displayMessage = request.getParameter("displayMessage");
                                            if (displayMessage != null && displayMessage.length() > 0) {
                                                out.println("<center>" + displayMessage + "</center>");
                                            }
                                        %>
                                        <center>
                                            <table  width="70%" cellpadding="3" border="1">
                                                <thead>
                                                    <tr >
                                                        <th colspan="2">Enter Information Here</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>First Name</td>
                                                        <td><input type="text" name="fname" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Last Name</td>
                                                        <td><input type="text" name="lname" value="" /></td>
                                                    </tr>

                                                    <tr>
                                                        <td>User ID</td>
                                                        <td><input type="text" name="userid" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Password</td>
                                                        <td><input type="password" name="passwd" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2" align="center"> <input type="submit" value="Submit" /></td>

                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">Already registered!! <a href="index.jsp">Login Here</a></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </center>
                                    </form>

                                    <div class="cleared"></div>
                                </div>
                            </div>
                            <div class="cleared"></div>
                        </div>
                    </div>
                </div>
                <div class="cleared"></div>
                <div class="art-footer">
                    <div class="art-footer-t"></div>
                    <div class="art-footer-l"></div>
                    <div class="art-footer-b"></div>
                    <div class="art-footer-r"></div>
                    <div class="art-footer-body">

                        <div class="art-footer-text">

                        </div>
                        <div class="cleared"></div>
                    </div>
                </div>
                <div class="cleared"></div>
            </div>
        </div>
        <div class="cleared"></div>


    </body>
</html>
