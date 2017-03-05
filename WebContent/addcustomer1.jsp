<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="inactive-server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
        <%
            if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
                response.sendRedirect("index.jsp?displayMessage=You are not logged in!");
                return;
            }
        %> 
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
                                                <ul class="art-vmenu">
                                                    <li>
                                                        <a href="addcustomer1.jsp" class="active"><span class="l"></span><span class="r"></span><span class="t">Add Customer</span></a>
                                                    </li>	
                                                    <li>
                                                        <a href="editcustomer1.jsp" ><span class="l"></span><span class="r"></span><span class="t">Edit Customer</span></a>
                                                    </li>
                                                    <li>
                                                        <a href="createaccount1.jsp" ><span class="l"></span><span class="r"></span><span class="t">Create Account</span></a>
                                                    </li>
                                                    <li>
                                                        <a href="deposit1.jsp" ><span class="l"></span><span class="r"></span><span class="t">Deposit Amount</span></a>
                                                    </li>
                                                    <li>
                                                        <a href="withdraw1.jsp" ><span class="l"></span><span class="r"></span><span class="t">Withdraw Amount</span></a>
                                                    </li>
                                                    <li>
                                                        <a href="transfer1.jsp" ><span class="l"></span><span class="r"></span><span class="t">Transfer Amount</span></a>

                                                    </li>
                                                    <li>
                                                        <a href="checkbalance.jsp" ><span class="l"></span><span class="r"></span><span class="t">Check Balance</span></a>
                                                    </li>
                                                    <li>
                                                        <a href="history.jsp" ><span class="l"></span><span class="r"></span><span class="t">Show Transaction History</span></a>
                                                    </li>
                                                    <li>
                                                        <a href="closeaccount.jsp" ><span class="l"></span><span class="r"></span><span class="t">Close Account</span></a>
                                                    </li>
                                                    <li>
                                                        <a href="logout.jsp" ><span class="l"></span><span class="r"></span><span class="t">Logout</span></a>
                                                    </li>
                                                </ul>
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
                                    <br></br>
                                    <h2 class="art-postheader">
                                        Welcome to FT Banking System
                                    </h2>
                                    <br></br>
                                    <form method="post" action="addcustomer2.jsp">
                                        <center>
                                            <%
                                                String displayMessage = request.getParameter("displayMessage");
                                                if (displayMessage != null && displayMessage.length() > 0) {
                                                    out.println("" + displayMessage + "");
                                                }
                                            %>
                                            <table  width="70%" cellpadding="3" border="1">
                                                <thead>
                                                    <tr>
                                                        <th colspan="2">Add Customer</th>
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
                                                        <td colspan="2" align="right"><input type="submit" value="Submit" /></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </center>
                                    </form>
                                    <br></br>
                                    <br></br>
                                    <br></br>

                                </div>

                                <div class="cleared"></div>
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
