<c:forTokens var="i" delims=","
        items="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z">
    <c:if test="${i == 'A'}">
    ...
    </c:if>
</c:forTokens>