while((temp = sIn.nextLine()) != null)
{
    out.println(temp);
    Thread.currentThread().sleep(1000);
    while(in.ready())System.out.println(in.readLine());
    out.flush();
    if(temp.equals("end")) break;
}