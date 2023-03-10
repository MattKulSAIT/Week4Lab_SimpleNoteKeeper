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
        
        String edit = request.getParameter("edit");
        br.close();
        if(edit == null){
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response); 
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response); 
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        
        pw.println(note.getTitle());
        pw.println(note.getContent());
        
        pw.close();
        
        request.setAttribute("note", note);
        
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }


}
