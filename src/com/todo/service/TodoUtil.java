package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "< 일정 추가 >\n"
				+ "제목 입력 > ");
		
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("이미 존재하는 일정입니다.");
			return;
		}
		sc.nextLine();
		System.out.println("내용 입력 > ");
		desc = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
		System.out.printf("일정이 추가 되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		String title = sc.next();
		
		System.out.println("\n"
				+ "< 일정 삭제 >\n"
				+ "삭제할 일정 제목 입력 >");
		
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.printf("입력하신 일정이 삭제 되었습니다.");
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "< 일정 편집 >\n"
				+ "편집할 일정 제목 입력 >");
		String title = sc.next().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("존재하지 않는 일정입니다.");
			return;
		}

		System.out.println("새로운 제목 입력 > ");
		String new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("이미 존재하는 일정의 제목입니다.");
			return;
		}
		sc.nextLine();
		System.out.println("새로운 내용 입력 > ");
		String new_description = sc.nextLine().trim();
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				System.out.println("일정이 편집되었습니다.");
			}
		}

	}

	public static void listAll(TodoList l) {
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
	
	public static void saveList(TodoList l, String filename) {
		Writer w;
		try {
			w = new FileWriter(filename);
			for (TodoItem item : l.getList()) {
				w.write(item.toSaveString());
			}
			w.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void loadList(TodoList l, String filename) {
		try {
			Reader r = new FileReader(filename);
			BufferedReader b =new BufferedReader (r);
			
			String line ="";
			while((line = b.readLine()) != null){
				  StringTokenizer st = new StringTokenizer(line ,"\n");
				  for (TodoItem item : l.getList()) {
						System.out.println(item.toString());
					}
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
}
