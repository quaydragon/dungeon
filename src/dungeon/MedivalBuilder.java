package dungeon;


/**
 * This interface creates the operators for the MedivalBuilderClass. 
 * 
 * @author quaydragon
 *
 */
public interface MedivalBuilder {
  
  /**
   * Adds a room to the level.
   */
  public void addRoom();
  
  /**
   * Adds the correct amount of goblins to the level.
   */
  public void addGoblins();
  
  /**
   * Adds the correct amount of orcs to the level.
   */
  public void addOrcs();
  
  /**
   * Adds the correct amount of ogres to the level.
   */
  public void addOgre();
  
  /**
   * Adds one human player to the level.
   */
  public void addHuman();
  
  /**
   * Adds potions to the level.
   */
  public void addPotion();
  
  /**
   * Adds gold to the level.
   */
  public void addGold();
  
  /**
   * Adds weapons to the level.
   */
  public void addWeapon();
  
  /**
   * Adds a special treasure to the level. 
   */
  public void addSpecial();
  
  /**
   * Builds the level.
   * 
   * @return the built level
   */
  public Level build();
  
  /**
   * Checks if anymore treasure needs to be added to the level. 
   */
  public void checkForLeftOverTreasure();
  
  

}
