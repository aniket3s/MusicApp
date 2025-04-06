import java.util.*;


public class Main {

    private static ArrayList<Album>albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Album1", "AC/DC");

        album.addSong("Rashtrageet", 0.52);
        album.addSong("Vande Mataram", 2.0);
        album.addSong("GaneshAarati", 6.05);
        album.addSong("Hanuman Chalisa", 5.10);
        albums.add(album);

        album = new Album("Album2","AJ/At");

        album.addSong("Rap God",4.09);
        album.addSong("Not Afraid",5.0);
        album.addSong("lose yourself", 4.5);

        albums.add(album);

        LinkedList<Song>playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Rashtrageet ",playList_1);
        albums.get(0).addToPlayList("Vande Mataram ",playList_1);
        albums.get(0).addToPlayList("GaneshAarati ",playList_1);
        albums.get(0).addToPlayList("Hanuman Chalisa ",playList_1);


        play(playList_1);
    }

    private static void play(LinkedList<Song> playList)
    {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size()==0)
        {
            System.out.println("This playlist have no song");
        } else
        {
            System.out.println(" Now Playing " + listIterator.next().toString());
            pritMenu();
        }

        while (!quit)
        {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action)
            {
                case 0 : {
                    System.out.println("playlist complete");
                    quit = true;
                    break;
                }
                case 1 : {
                    if (!forward) {
                        if (listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("No Song available , reached to the end of the list ");
                        forward = false;
                    }
                    break;
                }
                case 2 : {
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing " + listIterator.previous().toString());
                        } else {
                            System.out.println("we are at the first song ");
                            forward = false;
                        }
                    }
                    break;
                }
                case 3 :{
                    {
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                System.out.println("now Playing " + listIterator.previous().toString());
                                forward = false;
                            } else {
                                System.out.println("we are at the start of list");
                            }
                        } else {
                            if (listIterator.hasNext()) {
                                System.out.println("now playing " + listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("we have reached to the end of list");

                            }
                        }
                        break;
                    }
                }
                case 4 :
                printList(playList );
                break;
                case 5:
                    pritMenu();
                    break;

                case 6 : {
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious())
                                System.out.println("now playing " + listIterator.previous().toString());
                        }
                    }
                    break;
                }
            }
        }
    }

    public static void pritMenu()
    {
        System.out.println("All the Available options \n press");
        System.out.println("0 - Quit \n " +
                           "1 - To play next Song \n"+
                           "2 - to play prevoius song \n"+
                           "3 - Replay the current Song \n"+
                           "4 - list of all Songs \n"+
                           "5 - print all available options \n"+
                           "6 - delete current song from playList");
    }

    private static void printList(LinkedList<Song> playList)
    {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("______________________________________________");

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("_________________________________________________");
    }
}











