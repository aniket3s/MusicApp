import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private  String Artist;
    private ArrayList<Song> songs;

    public Album(String name, String Artist)
    {
        this.name = name;
        this.Artist = Artist;
        this.songs = new ArrayList<Song>();
    }
    public Album()
    {

    }

    public Song findSong(String title)
    {
        for (Song checkSong : songs)
        {
            if (checkSong.getTitle().equals(title))  return checkSong;
        }
        return null;
    }

    public boolean addSong(String title, double duration)
    {
        if (findSong(title)==null)
        {
            songs.add(new Song(title, duration));
//            System.out.println(title + " Successfully addded to the playlist ");
            return true;
        }
        else
        {
//            System.out.println("Song with name "+ title+" already exist int the list");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber , LinkedList<Song>playList)
    {
        int index = trackNumber -1 ;

        if (index > 0 && index <= this.songs.size())
        {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have tracknumber "+trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList)
    {
        for (Song checkedSong : this.songs)
        {
            if (checkedSong.getTitle().equals(title))
            {
                playList.add(checkedSong);
                return true;
            }
        }
//        System.out.println(title +" there is no such song int the album ");
        return false;
    }
}
