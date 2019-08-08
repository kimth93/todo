package kr.ac.skuniv.todo.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.todo.dto.Todo;
import kr.ac.skuniv.todo.service.TodoService;


@WebServlet("/todoList")
public class TodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TodoService todoService= new TodoService();
		List<Todo> todoList = todoService.getTodoList();
		
		//보여주는 부분은 jsp
		request.setAttribute("todoList", todoList);
		
		RequestDispatcher rd = request.getRequestDispatcher("todoList.jsp");

		rd.forward(request, response);
		
		
	}

}
