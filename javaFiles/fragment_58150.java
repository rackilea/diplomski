import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String answer = "Lore!m ips@um dol$or si%t amet, co¨nsectetur adi&piscing el*it. Mo(rbi pla)cerat, tu_rpis s_it am+et acc=umsan ve{nenatis, ma[gna r}isus ulla]mcorper an|te, ne\\c por,ttitor lac.us n:unc se;d el?it. Nul/la tristi°que posºuere felis, in ullamcorper sapien dignissim sit amet.";
        System.out.println(check(answer));
    }
    private static String check(String answer) {
        return answer.replaceAll("[\\p{S}\\p{P}º]+", "");
    }
}