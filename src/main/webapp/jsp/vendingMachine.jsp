<%-- 
    Document   : vendingMachine
    Created on : Oct 11, 2017, 11:27:24 AM
    Author     : BMMil
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>${moneyIn}<form id="totalInForm" class="form-horizontal" role="form" method="POST" action="addMoney">
                            <div class="form-group">
                                <label for="displayMoney" class="col-md-offset-3 col-md-6 col-md-offset-3 control-label" style="text-align:center;">
                                    Total $ In
                                </label>
                                <div class="col-md-offset-3 col-md-6 col-md-offset-3">
                                    <input id="displayMoney" type="text" class="form-control" value="$${moneyIn}" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-1 col-md-3 col-md-offset-1">
                                    <input type="submit" class="btn btn-default" value="Add Dollar" name="money" />
                                </div>
                                <div class="col-md-offset-1 col-md-3 col-md-offset-1">
                                    <input type="submit" class="btn btn-default" value="Add Quarter" name="money" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-1 col-md-3 col-md-offset-1">
                                    <input type="submit" class="btn btn-default" value="Add Dime" name="money"/>
                                </div>
                                <div class="col-md-offset-1 col-md-3 col-md-offset-1">
                                    <input type="submit" class="btn btn-default" value="Add Nickel" name="money"/>
                                </div>
                            </div>
                        </form>
    </body>
</html>
