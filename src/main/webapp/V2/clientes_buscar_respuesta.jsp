<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="pe.edu.tecsup.app.models.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    // request , es una variable predefinida en el JSP
	
		Cliente cliente = (Cliente) request.getAttribute("cliente_clave");
		
		if (cliente != null) {
			out.println("<ul>");
			out.println("<li>" + cliente.getNombreCompleto() + "</li>");
			out.println("</ul>");
		} else {
			out.println("<ul>");
			out.println("<li> CODIGO NO ENCONTRADO </li>");
			out.println("</ul>");
		}
	%>
	
	<p>Mostrar todos los registros de la base de datos :</p>

	<% 	
		ArrayList clientes 
			= (ArrayList) request.getAttribute("lista_clientes_clave");
	
		out.println(clientes);
	
	%>
	
</body>
</html>