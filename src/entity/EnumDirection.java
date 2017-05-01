package entity;

public class EnumDirection extends Entity {
	EnumDirection dir;

	public enum direction{
		NORTH, NORTHE, EAST, SOUTHE,
		SOUTH, SOUTHW, WEST, NORTHW
	}
	
	public EnumDirection getDir(){
		return dir;
	}
	
	public void setDir(EnumDirection e){
		dir = e;
	}
	
}
