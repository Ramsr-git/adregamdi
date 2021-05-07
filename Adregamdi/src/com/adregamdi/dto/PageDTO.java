package com.adregamdi.dto;

import lombok.Getter;

@Getter
public class PageDTO {
	
	// �ּ� ������ ��ȣ
	private int min;
	
	// �ִ� ������ ��ȣ
	private int max;
	
	// ���� ��ư�� ������ �̵��ϴ� ������ ��ȣ
	private int prevPage;
	
	// ���� ��ư�� ������ �̵��ϴ� ������ ��ȣ
	private int nextPage;
	
	// ��ü ������ ��
	private int pageCount;
	
	// ���� ������ ��ȣ
	private int currentPage;
	
	// contentCnt : ��ü �Խñ� ��
	// contentPageCnt : ������ �� �Խñ� ��
	// pagination : �� ���� ��Ÿ�� ������ ��ȣ ��
	public  PageDTO(int contentCnt, int currentPage, int contentPageCnt, int pagination) {
		
		// ���� ������ ��ȣ
		this.currentPage = currentPage;
		
		// ��ü ������ �� = ��ü �Խñ� �� / ������ �� �Խñ� ��
		pageCount = contentCnt / contentPageCnt;
	
		if(contentCnt % contentPageCnt > 0) {
			pageCount++;
		}
		
		min = ((currentPage-1) / pagination) * pagination + 1;
		max = min + pagination - 1;
		
		if(max > pageCount) {
			max = pageCount;
		}
		
		prevPage = min - 1;
		nextPage = max + 1;
		
		if(nextPage > pageCount) {
			nextPage = pageCount;
		}
	}
}
