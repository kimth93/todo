package kr.ac.skuniv.todo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.todo.dto.Todo;
import kr.ac.skuniv.todo.service.TodoService;

@WebServlet("/todoUpdate")
public class TodoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TodoService service = new TodoService();
		request.setCharacterEncoding("utf-8");
		Todo todo = new Todo();
		todo.setId(Integer.parseInt(request.getParameter("id")));
		//todo.setDone(Boolean.getBoolean(request.getParameter("done")));
		service.upDateTodo(todo.getId());
		
		response.sendRedirect("todoList");
	}

}
