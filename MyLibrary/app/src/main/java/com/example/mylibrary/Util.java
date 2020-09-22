package com.example.mylibrary;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;

    private static int id=0;

    public Util() {
        if (allBooks == null) {
            allBooks = new ArrayList<>();
            initAllBooks();
        }
        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<>();
        }
        if (alreadyReadBooks == null) {
            alreadyReadBooks = new ArrayList<>();
        }
    }
    static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }
    public boolean addCurrentlyReadingBook(Book book){
        return currentlyReadingBooks.add(book);
    }
    public boolean addAlreadyReadBook(Book book){
        return alreadyReadBooks.add(book);
    }
    public boolean addWantToReadBook(Book book){
        return wantToReadBooks.add(book);
    }
    public boolean removeCurrentlyReadingBook(Book book){
        return currentlyReadingBooks.remove(book);
    }
    public boolean removeAlreadyReadBook(Book book){
        return alreadyReadBooks.remove(book);
    }
    public boolean removeWantToReadBook(Book book){
        return wantToReadBooks.remove(book);
    }
    private static void initAllBooks(){
        //TODO: initialize all books array list
        String name = "";
        String auther = "";
        int pages = 0;
        String imageUrl = "";
        String description = "";

        id++;
        name = "Cutter and Bone";
        auther = "Newton Thornburg";
        pages = 320;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1328705160l/532369.jpg";
        description = "The headline reads ? LOCAL GIRL SLAIN, BODY FOUND IN TRASHCAN. When Richard Bone sees a picture of conglomerate tycoon J.J. Wolfe in the newspaper, he's struck by how closely he resembles the man Bone saw dumping the body: could this millionaire redneck be the killer? Bone's close friend Cutter, a crippled Vietnam vet, is convinced that Wolfe is the killer. With nothing much more to lose, the reckless Cutter and handsome gigolo Bone hit the road to the Wolfe headquarters in the Ozarks, totally unprepared for what awaits them. Cutter and Bone are two of the most brilliantly drawn characters in modern American fiction. Cutter and Bone is a brilliant look at the underbelly of post-Vietnam America. Filmed and immortalized as Cutter's Way, this new edition marks the return of one of the greatest American post-war novels.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Lush Life";
        auther = "Richard Price";
        pages = 464;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1316137153l/1862313.jpg";
        description = "In Lush Life, Richard Price tears the shiny veneer off the 'new' New York to show us the hidden cracks, the underground networks of control and violence beneath the glamour. Lush Life is an X-ray of the street in the age of no broken windows and \"quality of life\" squads, from a writer whose \"tough, gritty brand of social realism…reads like a movie in prose.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "The Digger's Game";
        auther = "George V. Higgins";
        pages = 214;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1338505148l/913409.jpg";
        description = "Jerry \"Digger\" Doherty is an ex-con and proprietor of a workingman's Boston bar, who supplements his income with the occasional \"odd job,\" like stealing live checks or picking up hot goods. His brother's a priest, his wife's a nag, and  he has a deadly appetite for martinis and gambling. On a trip to Vegas, the Digger finds himself in the sights of a loan shark known as “the Greek.” Luckily--if you call it luck--the Digger has been let in on a little job that can turn his gambling debt into a profit, if only he can pull it off without getting himself killed.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Night Dogs";
        auther = "Kent Anderson";
        pages = 544;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1320465055l/165475.jpg";
        description = "Night Dogs is an extraordinary work from a powerful and authentic voice in American fiction. Recoiling from the violence that Hanson deals with every day, the violence that is in Hanson, readers will also understand the compassion that drives him.  A novel remarkable for its razor-sharp characterizations and dialogue, its freshness of observation, Night Dogs--and Hanson--will remain etched in the memory for a long time to come.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "The Ice Harvest";
        auther = "Scott Phillips";
        pages = 240;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1347267765l/96621.jpg";
        description = "As lawyer Charlie Arglist prepares to leave Wichita, Kansas, with a suitcase full of stolen money, he revisits the scenes of his past--his angry ex-wife, ex-lovers, cops on the take, and bars filled with secrets that others will do anything to hide.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "The Day of the Jackal";
        auther = "Frederick Forsyth";
        pages = 358;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1405364996l/540020.jpg";
        description = "The Jackal. A tall, blond Englishman with opaque, gray eyes. A killer at the top of his profession. A man unknown to any secret service in the  world. An assassin with a contract to kill the world's most heavily guarded man.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Marathon Man";
        auther = "William Goldman";
        pages = 311;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1438709397l/61888.jpg";
        description = "Tom \"Babe\" Levy is a runner in every sense: racing tirelessly toward his goals of athletic and academic excellence--and endlessly away from the specter of his famous father's scandal-driven suicide. But an unexpected visit from his beloved older brother will set in motion a chain of events that plunge Babe into a vortex of terror, treachery, and murder--and force him into a race for his life . . . and for the answer to the fateful question, \"Is it safe?";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Devil in a Blue Dress";
        auther = "Walter Mosley";
        pages = 224;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1324578733l/819675.jpg";
        description = "Devil in a Blue Dress honors the tradition of the classic American detective novel by bestowing on it a vivid social canvas and the freshest new voice in crime writing in years, mixing the hard-boiled poetry of Raymond Chandler with the racial realism of Richard Wright to explosive effect.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Fletch";
        auther = "Gregory McDonald";
        pages = 197;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1389926023l/484531.jpg";
        description = "He’s an investigative reporter whose methods are a little unorthodox. Currently he’s living on the beach with the strung-out trying to find to the source of the drugs they live for.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Killing Floor";
        auther = "Lee Child";
        pages = 424;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1399313258l/78129.jpg";
        description = "Ex-military policeman Jack Reacher is a drifter. He's just passing through Margrave, Georgia, and in less than an hour, he's arrested for murder. Not much of a welcome. All Jack knows is that he didn't kill anybody. At least not here. Not lately. But he doesn't stand a chance of convincing anyone. not in Margrave, Georgia. Not a chance in hell.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "LaBrava";
        auther = "Elmore Leonard";
        pages = 432;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1347694793l/288989.jpg";
        description = "Photographer Joe LaBrava specialises in capturing the soul of Miami's street life & since he used to do dirty jobs for the government, he understands his subject very well. So when his friend Maury enlists his help to sort out a problem with an ex-film star, Joe is more than happy to help.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Lethal White";
        auther = "Robert Galbraith";
        pages = 650;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1559867637l/42283287.jpg";
        description = "When Billy, a troubled young man, comes to private eye Cormoran Strike's office to ask for his help investigating a crime he thinks he witnessed as a child, Strike is left deeply unsettled. While Billy is obviously mentally distressed, and cannot remember many concrete details, there is something sincere about him and his story. But before Strike can question him further, Billy bolts from his office in a panic.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "The Neon Rain";
        auther = "James Lee Burke";
        pages = 258;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1386748162l/55022.jpg";
        description = "Detective Dave Robicheaux has fought too many battles: in Vietnam, with killers and hustlers, with police brass, and with the bottle. Lost without his wife's love, Robicheaux's haunted soul mirrors the intensity and dusky mystery of New Orleans' French Quarter -- the place he calls home, and the place that nearly destroys him when he becomes involved in the case of a young prostitute whose body is found in a bayou. Thrust into the world of drug lords and arms smugglers, Robicheaux must face down a subterranean criminal world and come to terms with his own bruised heart in order to survive.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Hell to Pay";
        auther = "George Pelecanos";
        pages = 368;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1442010381l/7997658._SY475_.jpg";
        description = "Derek Strange and Terry Quinn, the team of private investigators who made their stunning debut in Right As Rain, are hired to find a 14-year-old white girl from the suburbs who's run away from home and is now working as a prostitute. The two ex-cops think they know D.C.'s dangers, but nothing in their experience has prepared them for Worldwide Wilson, the pimp whose territory they're intruding upon.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "The Poet";
        auther = "Michael Connelly ";
        pages = 656;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1498916469l/32498526.jpg";
        description = "Death is reporter Jack McEvoy's beat: his calling, his obsession. But this time, death brings McEvoy the story he never wanted to write--and the mystery he desperately needs to solve. A serial killer of unprecedented savagery and cunning is at large. His targets: homicide cops, each haunted by a murder case he couldn't crack. The killer's calling card: a quotation from the works of Edgar Allan Poe. His latest victim is McEvoy's own brother. And his last...may be McEvoy himself.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Chiefs";
        auther = "Stuart Woods";
        pages = 432;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1388177601l/417501.jpg";
        description = "Chiefs is the best kind of thriller, where the investigation plays out against the drama beneath the surface of a seemingly placid community, seething with the pressures of race, love, hate, and; always; political power, extending from the town fathers all the way to Washington, DC. With a new foreword by the author, this volume will be a collector's treasure for all fans of Stuart Woods.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "The Black Book";
        auther = "James Patterson";
        pages = 418;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1482726174l/30848685.jpg";
        description = "Being a cop runs in Billy Harney's family. The son of Chicago's Chief of Detectives whose twin sister, Patty, also followed in their father's footsteps, there's nothing Billy won't give up for the job, including his life. Left for dead alongside his tempestuous former partner and a hard-charging assistant district attorney out for blood, Billy miraculously survives. But he remembers nothing about the events leading up to the shootout. Charged with double murder and desperate to clear his name, Billy retraces his steps to get to the bottom of what happened. When he discovers the existence of a little black book that everyone who's anyone in Chicago will stop at nothing to get their hands on, Billy suspects it contains the truth that will either set him free...or confirm his worst fears.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Deliverance";
        auther = "James Dickey";
        pages = 278;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1452812511l/2213022._SY475_.jpg";
        description = "The setting is the Georgia wilderness, where the state's most remote white-water river awaits. In the thundering froth of that river, in its echoing stone canyons, four men on a canoe trip discover a freedom and exhilaration beyond compare. And then, in a moment of horror, the adventure turns into a struggle for survival as one man becomes a human hunter who is offered his own harrowing deliverance.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));

        id++;
        name = "Dark of the Moon";
        auther = "John Sandford";
        pages = 373;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1442687239l/988950._SY475_.jpg";
        description = "irgil Flowers — tall, lean, late thirties, three times divorced, hair way too long for a cop's — had kicked around a while before joining the Minnesota Bureau of Criminal Apprehension. First it was the army and the military police, then the police in St. Paul, and finally Lucas Davenport had brought him into the BCA, promising him, \"We'll only give you the hard stuff.\"\n" +
                "He'd been doing the hard stuff for three years now — but never anything like this";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));
        id++;
        name = "The Force";
        auther = "Don Winslow";
        pages = 496;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1487222482l/32075859.jpg";
        description = "The acclaimed, award-winning, bestselling author of The Cartel—voted one of the Best Books of the Year by more than sixty publications, including the New York Times—makes his William Morrow debut with a cinematic epic as explosive, powerful, and unforgettable as Mystic River and The Wire.";
        allBooks.add(new Book(id,name,auther,pages,imageUrl,description));
    }

}
