package dungeon;

public interface MedivalBuilder {
  
  
  //Should all of these be private? 
  public void addRoom();
  
  public void addGoblins();
  
  public void addOrcs();
  
  public void addOgre();
  
  public void addHuman();
  
  public void addPotion();
  
  public void addGold();
  
  public void addWeapon();
  
  public void addSpecial();
  
  public Level build();
  
  public void checkForLeftOverTreasure();
  
  

}
