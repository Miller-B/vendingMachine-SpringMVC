<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1 align="center">Vending Machine</h1>
            <hr/>
            <div class="row">
                <div id="vendItemsColumn" class="col-md-9">
                    <c:forEach var="item" items="${itemsList}">
                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <a style="text-decoration: none" href="selectItemId?itemId=${item.itemId}">
                                    <div class="panel-body">
                                        <p id="itemId">${item.itemId}</p>
                                        <p>${item.itemName}</p>
                                        <p>$${item.itemPrice}</p>
                                        <p>Quantity Left: ${item.inventoryCount}</p>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="col-md-3">
                    <div>
                        <form id="totalInForm" class="form-horizontal" role="form" method="POST" action="addMoney">
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
                    </div>
                    <hr/>

                    <div align="center" class="form" id="messages" role="form" method="GET" action="purchaseItem">
                        <h3>Messages</h3>
                        <input type="text" class="form-control" id="message" value="${message}" readonly="true"/>
                        <label for="selection" class="form-inline">Item:</label>
                        <input type="text" class="form-inline" id="selection" value="${selectedItem}">
                        <div class="btn btn-basic active">
                            <a href="purchaseItem?selectedItem=${selectedItem}"  type="button" id="selection" value="Make Purchase">Make Purchase</a>
                        </div>
                        <hr/>
                    </div>

                    <div align="center" class="form" id="change" method="POST" action="returnChange">
                        <h3 align="center">Change</h3>
                        <c:if test="${displayChange == true}" >
                        <input type="text" class="form-control" id="displayChange" value="QUARTERS:${change.coinQ}, DIMES:${change.coinD}, NICKELS:${change.coinN} "/>
                        </c:if>
                       
                        <button type="submit" id="changeRet" >Change Return</button>
                     
                    </div>

                </div>
            </div>
        </div>

    </div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>

