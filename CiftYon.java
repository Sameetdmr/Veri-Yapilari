package com.company;

public class CiftYon {
    int data;
    public CiftYon next,prev,last,first;
    public CiftYon() {
        first = null;
        last=null;
    }



    public void BasaEkle(int data){
        CiftYon add = new CiftYon();
        add.data=data;
        if(first==null){
            first=add;
            last=null;
        }
        else
        {
            add.next=first;
            first.prev=add;
            first=add;
        }
    }

    public void SonaEkle(int data){
        CiftYon add=new CiftYon();
        add.data=data;
        if(first==null)
        {
            first=add;
            last=add;
        }
        else{
            last.next=add;
            add.prev=last;
            last=add;
        }
    }


    public void ArayaEkle(int data,int Sayi){
        CiftYon add = new CiftYon();
        add.data=data;
        CiftYon temp=first;
        CiftYon prev=first;

        if(first==null){
            first=add;
            last=add;
        }
        else if(first.data==Sayi){
            add.next=first;
            first=add;
        }
        else
        {
            while(temp.data != Sayi)
            {
                if(temp.next==null){
                    System.out.println("Bulunamadı");
                }
                else
                {
                    prev=temp;
                    temp=temp.next;
                }
                add.next=prev.next;
                add.prev=prev;
                prev.next=add;
                temp.prev=add;
            }
        }
    }

    public void Sil(int data){
        CiftYon temp,prev;
        temp=first;
        prev=first;

        if(first.data==data){
            first=first.next;
        }
        else
        {
            while(temp.data != data){
                if(temp.next==null){
                    System.out.println("Bulunamadı silinecek sayi");
                }
                prev=temp;
                temp=temp.next;
            }
            prev.next=temp.next;
            temp.next.prev=prev;
        }
    }

    public void Yazdir(){
        CiftYon yaz = new CiftYon();
        yaz=first;
        while(yaz!=null){
            System.out.print("--"+yaz.data);
            yaz=yaz.next;
        }
    }

    public static void main(String[] args){
        CiftYon ekle = new CiftYon();
        ekle.BasaEkle(5);
        ekle.BasaEkle(6);
        ekle.Yazdir();
        System.out.println("-->");
        ekle.ArayaEkle(44,6);
        ekle.Yazdir();
        System.out.println("-->");
        ekle.ArayaEkle(01,6);
        ekle.Yazdir();
        ekle.Sil(6);
        System.out.println("-->");
        ekle.Yazdir();
        ekle.Sil(1);
        System.out.println("-->");
        ekle.Yazdir();
        ekle.Sil(44);
        System.out.println("-->");
        ekle.Yazdir();
        ekle.SonaEkle(6);
        System.out.println("-->");
        ekle.Yazdir();






    }
}
