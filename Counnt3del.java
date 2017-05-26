import java.util.Scanner;

class Count3del
{
	public static void main(String [] args)
	{
		System.out.print("请输入需要执行的数的总数：");
		Scanner sc = new Scanner(System.in);
		final int Totle=sc.nextInt();
		Child L,p;
		L=null;
		ChildCircle C = new ChildCircle();
		try
		{
			L=C.IniChildCircle(Totle);
		}
		catch (AnZeroException e)
		{
			e.Message("\n您输入了一个小于1的数！！！");
			System.exit(1);
		}
		int i,j,k,m;
		k=Totle;
		p=L;
		p=p.LeftChild;
		for (i=0;!p.IfOnly(p);i++)
		{
			k=k--;
			for (j=1;j<4;j++)
			{
//				p=p.RightChild;
				p=C.GoToRightOne(p);
				if (i<2)
				{
					i=0;
					k=Totle;
					m=k;
				}
			}
//			System.out.println("已删除此位置："+p.id);
			C.DeleteThisChild(p);
		}
		System.out.println("留下的一个是第："+L.SayId(p)+"个");
	}
}

class Child
{
	int id;
	Child LeftChild;
	Child RightChild;
	int SayId(Child a)
	{
		return a.id;
	}
	boolean IfOnly(Child a)
	{
		if (a.LeftChild==a || a.RightChild==a)
		{
			return true;
		}
		else return false;
	}
}

class AnZeroException extends Exception
{

	public void Message(String a)
	{
		System.out.println(a);
	}
}


class ChildCircle
{
	Child IniChildCircle(int a) throws AnZeroException
	{
		if (a<1)
		{
			throw new AnZeroException();
		}
		Child L=new Child();
		L.LeftChild=null;
		L.id=1;
		L.RightChild=null;
		Child p;
		p=L;
		int i;
		for (i=2;i<=a;i++)
		{
			Child q=new Child();
			p.RightChild=q;
			q.LeftChild=p;
			q.id=i;
			q.RightChild=null;
			p=q;
		}
		p.RightChild=L;
		L.LeftChild=p;
		return L;
	}
	Child GoToRightOne(Child a)
	{
		return a.RightChild;

	}
	Child DeleteThisChild(Child a)
	{
		Child p;
		p=a.LeftChild;
		a=a.RightChild;
		p.RightChild=a;
		a.LeftChild=p;
		return a;
	}
}
