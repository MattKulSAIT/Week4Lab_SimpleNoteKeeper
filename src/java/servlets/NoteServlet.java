/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author mdkul
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         String path = getServletContext().getRealPath("/WEB-INF/note.txt");
         BufferedReader br = new BufferedReader(new FileReader(new File(path)));
         
         String title = br.readLine();
         String content = br.readLine();
         
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response); 
        
        String edit = request.getParameter("edit");
        if(edit == null){}
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response); 
        }
    }
    
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                .forward(request, response); //These need to be updated to the proper file names 
    }


}
