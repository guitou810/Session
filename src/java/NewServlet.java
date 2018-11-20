/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedago
 */
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                String action = request.getParameter("action");
		String login = request.getParameter("loginuser");
                String guess = request.getParameter("guess");
                
                
                int nombret=-1;
                int essai = 0;

        try {
            switch (action) {
				case "Connexion": // Requête d'ajout (vient du formulaire de saisie)
					request.getSession(true).setAttribute("playername", login);
                                        Random r = new Random();
                                        int valeur = 0 + r.nextInt(100-0);
                                        nombret=valeur;
                                        System.out.println(nombret);
                                        request.setAttribute("essai", essai);
                                        request.getRequestDispatcher("newjsp1.jsp").forward(request, response);
					break;
				case "Deconnexion": // Requête de suppression (vient du lien hypertexte)
                                        request.getRequestDispatcher("newjsp.jsp").forward(request, response);
					break;
                                case "Deviner":
                                        int vl = Integer.valueOf(guess);
                                        if (vl==nombret){
                                            request.getRequestDispatcher("newjsp2.jsp").forward(request, response);
                                        }
                                        essai = essai +1;
                                        request.setAttribute("essai",essai);
                                        request.setAttribute("nombre",nombret);
                                        request.setAttribute("prop", vl);
                                        request.getRequestDispatcher("newjsp.jsp").forward(request, response);
                                case "Rejouer":
                                        request.getRequestDispatcher("newjsp.jsp").forward(request, response);
                                    break;
                                 
        }		
        } catch (Exception ex) {
			Logger.getLogger("discountEditor").log(Level.SEVERE, "Action en erreur", ex);
			request.setAttribute("message", ex.getMessage());
    }finally {

		}
		// On continue vers la page JSP sélectionnée
		request.getRequestDispatcher("newjsp.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}// </editor-fold>


