
import java.util.Map;
import java.util.HashMap;

public class MainCommandProccessor implements CommandProccessor {

    private Map<String, CommandProccessor> subCommands = new HashMap<>();
    
    public MainCommandProccessor(){
        
    }

    public void addSubCommand(String name, CommandProccessor subCommand){
        this.subCommands.put(name, subCommand);
    }

    @Override
    public void execute(String command){
        String[] commands = command.split(" ", 2);
        for(String s : subCommands.keySet()){
            if(s.equals(commands[0])){
                if(commands.length < 2){
                    subCommands.get(s).execute("");
                }
                else{
                    subCommands.get(s).execute(commands[1]);
                }
            }
        }
        return;
    }

    
}