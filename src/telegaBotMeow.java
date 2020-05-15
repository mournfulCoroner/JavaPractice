import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.SendMessage;


import java.io.IOException;
import java.util.List;

public class telegaBotMeow{
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("1219222104:AAHqvIwlmgCDv4qd2OkL-mziLNyUO2nJbkI");
        ParseMode parseMode = ParseMode.Markdown;

        bot.setUpdatesListener(updates -> {
            for (Update update: updates) {
                long chatId = update.message().chat().id();
                    Message mes = update.message();
                    System.out.println("Входящее сообщение: " + mes.text());
                    String[] rows = mes.text().split(" ");

                    switch(mes.text())
                    {
                        case "/start":
                            bot.execute(new SendMessage(chatId,"Моя магия к твоим услугам, гость. Поведай мне название _города_, и я расскажу о нём _всё_, что ты хочешь знать.").parseMode(parseMode));
                            continue;
                        case "Спасибо":
                        case "спасибо":
                            bot.execute(new SendMessage(chatId,"Не стоит благодарности, я всегда рад помочь юным волшебникам."));
                            continue;
                        default:
                            if(rows.length <= 3 && rows.length != 0)
                            {
                                    Connection yay;
                                    if(rows.length == 1) yay = new Connection(rows[0]);
                                    else if(rows.length == 3) yay = new Connection(rows[0] + "-" + rows[1] + "-" + rows[2]);
                                    else yay = new Connection(rows[0] + "-" + rows[1]);
                                bot.execute(new SendMessage(chatId,yay.get()).parseMode(parseMode));
                            }
                            else {
                                bot.execute(new SendMessage(chatId, "Что-то не пойму твои речи, сынок. Подучись сначала, а потом поговорим."));
                            }
                            break;
                    }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });


    }
}
