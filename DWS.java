import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.event.ActionListener;

public class DWS {
    public static void loooop(String URLL, String CONTENT, String USERNAME, String AVATARURL) {
        while (true) {
            poster(URLL, CONTENT, USERNAME, AVATARURL);
        }
    }

    public static void poster(String URLL, String CONTENT, String USERNAME, String AVATARURL) {
        try {

            if (AVATARURL.isEmpty()) {
                Random random = new Random();
                int randomNumber = random.nextInt(999999 - 100000) + 100000;
                AVATARURL = "https://robohash.org/" + randomNumber;
            }

            String[] noms = {"KillerBot78", "LaKeketteAJP", "Arigato", "Hacker", "MoguMogu", "RedBull", "OnePiece", "Naruto", "(o_o)", "DiscordAdmin", "CorruptedBot", "Creeper3000", "God", "RobloxPro", "ArandomUserName", "DiScOrDiSbAd", "SunrayRTX", "VSCODEPRIME", "Raspberrypi69", "answer42", "Iloveme", "Iloveyou", "IDK", "LesGilletsJaunesEnSueurs", "Kirikou", "Banana", "MoiJeDitHaagrah", "CocaColaRicola", "CocaPepsiMonoprixCola"};
            String[] phrases = {"He is my classmate.", "There are no dogs bigger than this one.", "Tokyo is bigger than Rome.", "You must be happy.", "I wish Ubers weren't so expensive.", "The sponge absorbed the water quicker than the towel.", "She woke up to the sound of the radio blaring.", "It's currently raining.", "He threatened to tell everyone about the time she threw up in his shoes when she was drunk.", "She had never had prosecco but she wanted to try it.", "My mom drove me to school fifteen minutes late on Tuesday.", "You’ll get used to it.", "Tom is really tall.", "The chandelier swayed in the breeze, sending dust drifting over the tables.", "It was a massive lightning storm.", "I'm going to the concert.", "Would you like a bigger one?", "My shoes are blue with yellow stripes and green stars on the front.", "You can’t go out with everyone who fancies you.", "What's your favorite toy to play with?", "To expand my knowledge on the topic, I read a book.", "The earth is like a ball with a big magnet in it.", "The castle is on top of a cliff.", "A sun burn can peel if its bad enough.", "The mouse was so hungry he ran across the kitchen floor without even looking for humans.", "I want to talk to Prince Harry when I’m in England.", "The footballers were very upset when they cancelled the game because of lightning threats.", "Mother doesn't make things up.", "It was especially rainy that night.", "I’d like to be catcalled.", "I love my new pets.", "Your first week of yoga classes is on us.", "My favorite dress was when I spilled ketchup on it last night.", "He's working with theme.", "He’s stretching the truth.", "Going to a bar is a fun thing to do.", "She had never appreciated radio news shows.", "Do you have any hidden talents?", "That makes a big difference, doesn't it?", "What should you do if you find a spider on your bed?", "A huge wave turned over his canoe.", "Let sleeping dogs lie.", "I miss my college friends.", "Imagine I am deciding if I like some new, heretofore untasted food.", "She did it knowing it was wrong — knowing he wouldn't do as he promised, that her work was useless, that he was going to kill again anyway.", "She was drenched the moment she stepped outside.", "She was dying to get breakfast out, but she couldn't afford it.", "There is a dictionary open on the table.", "The tornado went down her street, straight past her house, and picked up a raccoon.", "He said he didn’t want to hotwire a car.", "She wanted to live in a skyscraper but she settled for a walkup.", "He snuck into the house after midnight to investigate.", "When I ripped the tape off, it hurt.", "I would like to make toast.", "She liked vintage jeans because they fit her better.", "I am dirt poor.", "My father doesn’t speak good English.", "How's it going now that you're all alone?", "We've been trying to go there for so long.", "Do you think Tom will come?", "The earth is far larger than the moon.", "I eat my asparagus steamed.", "I will put my food on the placemat.", "My family just got home.", "We weren't in the best place.", "She had a cut on her finger that made it very hard to type.", "It is usually the best singer who wins the show.", "It wasn't any bigger than a soccer ball.", "She is eating a midnight snack.", "She doesn't use a computer.", "The mailbox was bent and broken and looked like someone had knocked it over on purpose.", "I’m the Designed Driver so I'm drinking Shirley Temples.", "You, as the maker, get to decide the design.", "I want to sit down.", "I love you, but I'm sorry, I have to go.", "The new one's twice as big as the old one.", "What should you do if you find a spider on your bed?", "Shake your hips back and forth!", "When she visited Chicago, she made sure to stop at the Art Institute and see The Nighthawks by Edward Hopper.", "Tom had big money problems.", "Having a monkey is illegal.", "She didn't understand why everyone loved his music so much.", "It could be the biggest mistake you ever make.", "That's an outright lie.", "I have no idea.", "I will open the door.", "Tom asked me if he was invited to the party.", "My dog, Jake, barked at the mail carrier.", "I get on the bus.", "His chest is muscular.", "It takes place in a school.", "She likes scrambled egg whites, but not scrambled eggs.", "This town isn't big enough for the both of us.", "Cows like to stand outside and eat grass all day.", "I’m excited about the future.", "I wish Ubers weren't so expensive.", "What are your favorite candies?", "Would you like to leave a message?", "Wiggle your fingers!", "What a big supermarket!"};
            if (USERNAME.isEmpty()) {
                Random random = new Random();
                USERNAME = noms[random.nextInt(noms.length)];
            }

            if (CONTENT.isEmpty()) {
                Random random = new Random();
                CONTENT = phrases[random.nextInt(phrases.length)];
            }

            URL url = new URL(URLL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = "{\"username\": \""+USERNAME+"\", \"content\": \""+CONTENT+"\", \"avatar_url\": \""+AVATARURL+"\"}";

            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                wr.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int HEIGHT = 315;
        int WIDTH = 300;
        int BORDER = 15;

        JFrame frame = new JFrame("Discord Webhook Spammer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton Startbutton = new JButton("Loop");
        Startbutton.setBounds(BORDER, HEIGHT-100, (WIDTH/2)-(BORDER), 60);

        JButton Sendbutton = new JButton("Send");
        Sendbutton.setBounds((WIDTH/2), HEIGHT-100, (WIDTH/2)-(BORDER), 60);

        JLabel inputTextURL = new JLabel("Webhook URL:");
        inputTextURL.setBounds(50,0,200,30);

        JTextField URLtextField = new JTextField();
        URLtextField.setBounds(50, 25, 200, 30);

        JLabel usernameWebhook = new JLabel("Username :");
        usernameWebhook.setBounds(50,50,200,30);

        JTextField usernametextField = new JTextField();
        usernametextField.setBounds(50, 75, 200, 30);

        JLabel avatarURL = new JLabel("Avatar URL:");
        avatarURL.setBounds(50,100,200,30);

        JTextField avatarURLtextField = new JTextField();
        avatarURLtextField.setBounds(50, 125, 200, 30);

        JLabel messageContent = new JLabel("Message Content:");
        messageContent.setBounds(50,150,200,30);

        JTextField messageContenttextField = new JTextField();
        messageContenttextField.setBounds(50, 175, 200, 30);


        frame.add(inputTextURL);
        frame.add(URLtextField);

        frame.add(usernameWebhook);
        frame.add(usernametextField);

        frame.add(avatarURL);
        frame.add(avatarURLtextField);

        frame.add(messageContent);
        frame.add(messageContenttextField);

        frame.add(Startbutton);
        frame.add(Sendbutton);


        Startbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!URLtextField.getText().isEmpty()) {
                    inputTextURL.setForeground(Color.BLACK);
                    Thread thread = new Thread(() -> {
                        loooop(URLtextField.getText(), messageContenttextField.getText(), usernametextField.getText(), avatarURLtextField.getText());
                    });
                    thread.start();
                } else {
                    inputTextURL.setForeground(Color.RED);
                    System.out.println("Error: Webhook url empty.");
                }
                
            }
        });

        Sendbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!URLtextField.getText().isEmpty()) {
                    inputTextURL.setForeground(Color.BLACK);
                    poster(URLtextField.getText(), messageContenttextField.getText(), usernametextField.getText(), avatarURLtextField.getText());
                    
                } else {
                    System.out.println("Error: Webhook url empty.");
                    inputTextURL.setForeground(Color.RED);
                }
                
            }
        });

        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(null);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
