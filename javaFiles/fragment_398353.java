<c:forEach var="item" items="${items}">
           <form action="/take-item/${item.id}" method="POST">
                <c:if test="item.quantity=='0'">
                    <h4 style="color:red"> Item out of stock</h4>
                </c:if>
                <div class="item rounded m10">
                   <img src="${item.image}" width="150" height="150"/>
                    <h5>${item.productTitle}</h5>
                    <p>${item.price} <span class="nortal">LT</span></p>
                    <button class="btn btn-success">Imu!</button>
                </div>
             </form>
       </c:forEach>