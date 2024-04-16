<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Description</th>
				<th scope="col">Quantité</th>
				<th scope="col">Prix</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${articles}" var="article">
			<tr>
				<th scope="row">${article.id}</th>
				<td>${article.description}</td>
				<td>${article.quantite}</td>
				<td>${article.price}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</div>