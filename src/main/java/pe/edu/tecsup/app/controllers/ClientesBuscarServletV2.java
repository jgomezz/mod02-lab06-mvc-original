package pe.edu.tecsup.app.controllers;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet("/ClientesBuscarServletV2")
public class ClientesBuscarServletV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesBuscarServletV2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void indentificacion( String nombre, String apellido) {
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(  HttpServletRequest request, 
							
			 				HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		String criterio = request.getParameter("txtNombres");
		
		System.out.println("Dentro de ClientesBuscarServlet: " + criterio);

		// datos
		
		Cliente c1 = new Cliente();
		c1.setCodigo("11");
		c1.setNombres("David");
		c1.setPaterno("Rodriguez");
		c1.setMaterno("Condezo");

		Cliente c2 = new Cliente();
		c2.setCodigo("12");
		c2.setNombres("Juan");
		c2.setPaterno("Perez");
		c2.setMaterno("Quispe");

		// container
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		if(criterio.equals("CERO")) {
			// nothing
		} else if (criterio.equals("UNO")) {
			clientes.add(c1);	
		} else if (criterio.equals("DOS")) {
			clientes.add(c1);
			clientes.add(c2);		
		} else {
			
		}
		
		//clientes.add(c1);
		//clientes.add(c2);

		
		// Guardando datos en el scope REQUEST , SESSION , APPLICATION
		// para pasarselo al JSP
		//                    << key >> , << value >>
		request.setAttribute("clientes_005", clientes);	

		
		// Envia la salida al jsp : clientes_buscar.jsp
		RequestDispatcher rd = 
				request.getRequestDispatcher("clientes_buscar_respuesta.jsp");
		
		// Hacer el forward
		rd.forward(request, response);
	}

}
