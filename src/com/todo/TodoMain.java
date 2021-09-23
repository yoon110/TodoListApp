package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean isList = false;
		boolean quit = false;
		TodoUtil.loadList(l, "todoList.txt");
		Menu.displaymenu();
		do {
			Menu.prompt();
			isList = false;
			String choice = sc.next();
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				System.out.println("< 일정 목록 >");
				TodoUtil.listAll(l);
				break;

			case "ls_name_asc":
				System.out.println("< 제목 순으로 목록 정렬 >");
				l.sortByName();
				isList = true;
				break;

			case "ls_name_desc":
				System.out.println("< 제목 역순으로 목록 정렬 >");
				l.sortByName();
				l.reverseList();
				isList = true;
				break;
				
			case "ls_date":
				System.out.println("< 날짜 순으로 목록 정렬 >");
				l.sortByDate();
				isList = true;
				break;
				
			case "menu":
				Menu.displaymenu();
				break;

			case "exit":
				quit = true;
				break;
				
			default:
				System.out.println("정확한 명령어를 입력해주세요. (명령어 메뉴 - menu)");
				break;
			}
			
			if(isList) l.listAll();
		} while (!quit);
		TodoUtil.saveList(l, "todoList.txt");
	}
}
