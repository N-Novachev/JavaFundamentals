package PreviousFinalExams.P01ProgrammingFundamentalsFinalExamRetake;
//On the first line of the standard input, you will receive an integer n – the number of pieces you will initially have. On the next n lines, the pieces themselves will follow with their composer and key, separated by "|" in the following format: "{piece}|{composer}|{key}".
//Then, you will be receiving different commands, each on a new line, separated by "|", until the "Stop" command is given:
//"Add|{piece}|{composer}|{key}":
//You need to add the given piece with the information about it to the other pieces and print:
//"{piece} by {composer} in {key} added to the collection!"
//If the piece is already in the collection, print:
//"{piece} is already in the collection!"
//"Remove|{piece}":
//If the piece is in the collection, remove it and print:
//"Successfully removed {piece}!"
//Otherwise, print:
//"Invalid operation! {piece} does not exist in the collection."
//"ChangeKey|{piece}|{new key}":
//If the piece is in the collection, change its key with the given one and print:
//"Changed the key of {piece} to {new key}!"
//Otherwise, print:
//"Invalid operation! {piece} does not exist in the collection."
//Upon receiving the "Stop" command, you need to print all pieces in your collection, sorted by their name and by the name of their composer in alphabetical order, in the following format:
//"{Piece} -> Composer: {composer}, Key: {key}"
import java.util.*;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> inputPieces = new HashMap<String, List<String>>();
        for (int i = 0; i < n; i++) {
            List<String> pieceParts = new ArrayList<String>(Arrays.asList(scanner.nextLine().split("\\|")));
            String pieceName=pieceParts.get(0);
            String composer=pieceParts.get(1);
            String key=pieceParts.get(2);
            List<String>pieceInfo=new ArrayList<>();
            pieceInfo.add(composer);
            pieceInfo.add(key);
            inputPieces.put(pieceName,pieceInfo);
        }
        String command=scanner.nextLine();
        while(!command.equals("Stop")){
            String[] commandParts=command.split("\\|");
            String commandName=commandParts[0];
            switch(commandName){
                case "Add":
                    String newPieceName = commandParts[1];
                    String composer = commandParts[2];
                    String key = commandParts[3];
                    if(inputPieces.containsKey(newPieceName)){
                        System.out.printf("%s is already in the collection!%n",newPieceName);
                    }
                    else{
                        List<String> newPieceInfo = new ArrayList<>();
                        newPieceInfo.add(composer);
                        newPieceInfo.add(key);
                        inputPieces.put(newPieceName,newPieceInfo);
                        System.out.printf("%s by %s in %s added to the collection!%n", newPieceName, composer, key);
                    }
                    break;
                case "Remove":
                    String pieceForRemove= commandParts[1];
                    if(inputPieces.containsKey(pieceForRemove)){
                        inputPieces.remove(pieceForRemove);
                        System.out.printf("Successfully removed %s!%n", pieceForRemove);
                    }
                    else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceForRemove);
                    }
                    break;
                case "ChangeKey":
                    String pieceName=commandParts[1];
                    String newKey=commandParts[2];
                    if(!inputPieces.containsKey(pieceName)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    }
                    else{
                        List<String> currentPieceInfo = inputPieces.get(pieceName);
                        currentPieceInfo.remove(1);
                        currentPieceInfo.add(newKey);
                        inputPieces.put(pieceName, currentPieceInfo);
                        System.out.printf("Changed the key of %s to %s!%n", pieceName, newKey);
                    }
                    break;
            }
            command=scanner.nextLine();
        }
        inputPieces.entrySet()
                .forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
