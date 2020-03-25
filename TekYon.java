package com.company;

public class TekYon {

    public int data;
    public TekYon next;
    public TekYon first,last;

    public TekYon(){
        first=null;
        last=null;
    }

    public void BasaEkle(int data){
        TekYon add = new TekYon();
        add.data=data;
        if(first==null){
            first=add;
            last=add;
        }
        else {
            add.next=first;
            first=add;
        }
    }

    public void SonaEkle(int data){
        TekYon add = new TekYon();
        add.data=data;
        if(first==null){
            first=add;
            last=add;
        }
        else {
            last.next=add;
            last=add;
        }
    }

    public void ArayaEkle(int data,int Sayi){
        TekYon add = new TekYon();
        add.data=data;
        TekYon temp=first;
        TekYon prev=first;

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
                prev.next=add;
            }
        }
    }
    public void Yazdir(){
        TekYon yaz = new TekYon();
        yaz=first;
        while(yaz!=null){
            System.out.print("---"+yaz.data);
            yaz=yaz.next;
        }
    }

    public void Sil(int data){
        TekYon temp,prev;
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
        }
    }

    public static void main(String[] args){
        TekYon ekle = new TekYon();
        ekle.BasaEkle(5);
        ekle.BasaEkle(6);
        ekle.BasaEkle(7);
        ekle.BasaEkle(8);
        ekle.BasaEkle(9);
        ekle.BasaEkle(10);
        ekle.BasaEkle(11);
        ekle.Yazdir();
        ekle.Sil(9);
        System.out.println("=>>");
        ekle.Yazdir();
        ekle.SonaEkle(13);
        System.out.println("=>>");
        ekle.Yazdir();
        ekle.ArayaEkle(44,8);
        System.out.println("=>>");
        ekle.Yazdir();
        ekle.Sil(5);
        System.out.println("=>>");
        ekle.Yazdir();
    }
}
