package org.zhxie.sprinpoker.domain;

public class Room {

	private String roomNum;

	private String creator;

	private String name;

	private String desc;

	public Room() {

  }

	public Room(String roomNum, String creator) {
		super();
		this.roomNum = roomNum;
		this.creator = creator;
	}

  public Room(String roomNum, String creator, String name, String desc) {
    this(roomNum, creator);
	  this.name = name;
	  this.desc = desc;
  }

  public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
