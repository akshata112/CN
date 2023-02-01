#include<stdio.h>
#define bucketSize 500

void bucketInput(int a,int b)
{
	if(a > bucketSize)
		printf("\n\t\tBucket overflow");
	else{
		while(a > b){
			printf("\n\t\t%d bytes outputted.",b);
			a-=b;
		}
		if(a > 0)
			printf("\n\t\tLast %d bytes sent\t",a);
		printf("\n\t\tBucket output successful");
	}
}
int main()
{
	int op,pktSize;
	printf("Enter output rate : ");
	scanf("%d",&op);
	for(int i=1;i<=5;i++)
	{
		pktSize=rand()%700;
		printf("\nPacket no %d \tPacket size = %d",i,pktSize);
		bucketInput(pktSize,op);
	}
	return 0;
}
