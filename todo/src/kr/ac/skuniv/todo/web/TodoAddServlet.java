package kr.ac.skuniv.todo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.DALOAD;

import kr.ac.skuniv.todo.dao.TodoDAO;
import kr.ac.skuniv.todo.dto.Todo;
import kr.ac.skuniv.todo.service.TodoService;

@WebServlet("/todoAdd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TodoDAO dao = new TodoDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		TodoService service = new TodoService();
		
		Todo todo = new Todo();
		request.setAttribute("todoInfo", todo);
		todo.setTodo(request.getParameter("todo"));
		
		boolean resultFlag = dao.addTodo(todo);
		response.sendRedirect("todoList");
		
		
	}

}
