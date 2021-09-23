package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("-----------MENU-----------");
        System.out.println("add          - 일정 추가");
        System.out.println("del          - 일정 삭제");
        System.out.println("edit         - 일정 편집");
        System.out.println("ls           - 일정 목록");
        System.out.println("ls_name_asc  - 이름 순 정렬");
        System.out.println("ls_name_desc - 이름 역순 정렬");
        System.out.println("ls_date      - 날짜 순 정렬");
        System.out.println("exit         - 종료");
    }
    

	public static void prompt() {
		// TODO Auto-generated method stub
		System.out.println("\n입력 >");
	}
}
