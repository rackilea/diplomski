RandomAccessFile raf = new RandomAccessFile(this.archive, "r");

/* Trying to read */
raf.seek(arquivos.get(pos).getPosicaoInicio());
byte[] buf = new byte[8192]; // or more, whatever you like really

/* Writing */
File futuroArquivo = new File(arquivos.get(pos).getNome());
FileOutputStream fos = new FileOutputStream(futuroArquivo);
int count;
long rest = arquivos.get(pos).getTamanho();
while (rest > 0 && (count = raf.read(buf, 0, (int)Math.min(buf.length, rest))) > 0)
{
    fos.write(buf, 0, count);
    rest -= count;
}
fos.close();
raf.close();