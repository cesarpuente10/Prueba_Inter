import java.util.*;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    /* ESTE ES CODIGO DE UN MAL DISEÑO
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    */
   /*eSTE ES CODIGO DE UN BUEN DISEÑO
    */
   private String description;
   // private Room northExit;
   // private Room southExit;
   // private Room eastExit;
   // private Room westExit;
    
    //iMPLEMENTACION DE LAS SALIDAS USANDO HashMap
    private HashMap<String, Room> salidas;
    /**
     * Documantacion aqui
     */
    public Room getExit(String direction)
    {
        /*
        if(direction.equals("north"))
            return northExit;
        if(direction.equals("south"))
            return southExit;
        if(direction.equals("east"))
            return eastExit;
        if(direction.equals("west"))
            return westExit; 
            */
          //Codigo todavia mejor diseñado
        return salidas.get(direction);
        
    }
    /**
     * Metodo que indica cuales salidas tiene el Room
     */
    public String getExitString()
    {
        String cadena = "Las salidas son: ";
        Set<String> direcciones = salidas.keySet();
        for(String exit : direcciones)
        {
            cadena = cadena + ", " + exit;
        }
        return cadena;
    }
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        salidas = new HashMap<String,Room>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room arriba, Room abajo) 
    {
        if(north != null)
            salidas.put("north", north);
        if(east != null)
            salidas.put("east", east);
        if(south != null)
            salidas.put("south", south);
        if(west != null)
            salidas.put("west", west);
        if(arriba != null)
            salidas.put("arriba", arriba);
        if(abajo != null)
            salidas.put("abajo", abajo);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

}
