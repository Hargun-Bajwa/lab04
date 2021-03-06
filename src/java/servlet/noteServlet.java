
package servlet;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 839217
 */
public class noteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        
        
            Note note = new Note();
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
       
            
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            
            
            note.setTitle(reader.readLine());
            note.setContent(reader.readLine());
            
            request.setAttribute("note", note);
        }  
     

       
        if (request.getParameter("edit") == null){ 
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String title = request.getParameter("title");
        String content = request.getParameter("content");
        Note note = new Note(title,content);
        note.setTitle(title);
        note.setContent(content);
        request.setAttribute("note", note);
        
        try {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
             try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path,false)))) {
                 pw.println(title);
                 pw.println(content);
                 pw.close();
             }
                  
        }        
        catch(IOException e){
        }
       
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
      
    }


}
