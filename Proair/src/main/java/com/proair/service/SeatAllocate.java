package com.proair.service;

import org.springframework.stereotype.Service;

import com.proair.model.SeatRow;

@Service
public class SeatAllocate {
	SeatRow[] seatList = new SeatRow[100];
	int rightPivot, leftPivot, middlePivot = 0;

	public void allocate(int number) {
		if (number == 2) {
			if (leftPivot==0 || leftPivot < rightPivot) {
				String[] left = { "A", "B" };
				seatList[leftPivot] = new SeatRow();
				seatList[leftPivot].setLeft(left);
				leftPivot++;
			} else {
				String[] right = { "F", "G" };
				seatList[rightPivot] = new SeatRow();
				seatList[rightPivot].setRight(right);
				rightPivot++;
			}
		} else {
			seatList[middlePivot] = this.seatList[middlePivot];
			if(seatList[middlePivot] == null) {
			seatList[middlePivot] = new SeatRow();
			}
			String[] middle = seatList[middlePivot].getMiddle();
			for (int i = 0; i < number; i++) {
				int count = 0;
				for(String str : middle) {
					if(str != null) {
						count++;
					}
				}
				if (count < 3) {
					middle[count + i] = "Allocated";
					seatList[middlePivot].setMiddle(middle);
				}
				if (count == 3) {
					middlePivot++;
				}
			}
		}
	}

	public void display() {
		for (SeatRow str : seatList) {
			if (str != null) {
				for (String s : str.getLeft()) {
					System.out.println(s + " ");
				}
				for (String s : str.getMiddle()) {
					System.out.println(s + " ");
				}
				for (String s : str.getRight()) {
					System.out.println(s + " ");
				}
			}
		}
	}

}
