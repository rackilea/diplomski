import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import.org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.ArrayList;
import java.util.List;

if (message_text.equals("test")) 
    {InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
            List < List < InlineKeyboardButton >> rowsInline = new ArrayList < > ();
            List < InlineKeyboardButton > rowInline = new ArrayList < > ();
            rowInline.add(new InlineKeyboardButton().setText("Open Browser").setUrl("https://www.google.com/"));
            rowsInline.add(rowInline);
            markupInline.setKeyboard(rowsInline);
            message.setReplyMarkup(markupInline);
        }