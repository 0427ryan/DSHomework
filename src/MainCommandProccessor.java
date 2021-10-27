
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
        for(String s : subCommands.keySet()){
            if(command.contains(s)){
                subCommands.get(s).execute(command.replaceFirst(s, ""));
                return;
            }
        }
        System.out.println("查無此命令");
        return;
    }

    
}