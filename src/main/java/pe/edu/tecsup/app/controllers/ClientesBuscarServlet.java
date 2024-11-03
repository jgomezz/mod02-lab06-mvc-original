package pe.edu.tecsup.app.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.tecsup.app.models.Cliente;

/**
 * Servlet implementation class ClientesBuscarServlet
 */
@WebServlet("/ClientesBuscarServlet")
public class ClientesBuscarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private Map<String, Cliente> clientes = new HashMap<String, Cliente>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesBuscarServlet() {
        super();

        // Carga de datos	
        Cliente c1 = new Cliente();
		c1.setCodigo("X001");
		c1.setNombres("David");
		c1.setPaterno("Rodriguez");
		c1.setMaterno("Condezo");

		Cliente c2 = new Cliente();
		c2.setCodigo("X002");
		c2.setNombres("Juan");
		c2.setPaterno("Perez");
		c2.setMaterno("Quispe");

		Cliente c3 = new Cliente();
		c3.setCodigo("X003");
		c3.setNombres("Jaime");
		c3.setPaterno("Perez");
		c3.setMaterno("Garcia");
		
		clientes.put(c1.getCodigo(), c1);
		clientes.put(c2.getCodigo(), c2);
		clientes.put(c3.getCodigo(), c3);

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(  HttpServletRequest request, 
							
			 				HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		String criterio = request.getParameter("txtCodigo");
		
		System.out.println("Dentro de ClientesBuscarServlet: " + criterio);

		// datos
		
		Cliente cliente = clientes.get(criterio);
		
		if ( clientes != null) {
			// Guardando datos en el scope:
			//		REQUEST 	--> 
			//		SESSION 	-->
			//		APPLICATION -->
			// para pasarselo al JSP
			//                    << key >> , << value >>
			request.setAttribute("cliente_clave", cliente);	
		}
		
		//System.out.println(listaClientes);
		//System.out.println(clientes.values());
		
		// Guardo el listado de clientes en el request
		//request.setAttribute("lista_clientes_clave", listaClientes);	
		
		// Envia la salida al jsp : clientes_buscar.jsp
		RequestDispatcher rd = 
				request.getRequestDispatcher("clientes_buscar_respuesta.jsp");
		
		// Hacer el forward
		rd.forward(request, response);
	}

}
